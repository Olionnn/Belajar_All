package service

import (
	"bjrresfulapi/model/domain"
	"bjrresfulapi/model/web"
	"bjrresfulapi/repository"
	"context"
	"database/sql"

	"github.com/go-playground/validator/v10"
)

type CategoryServiceImpl struct {
	CategoryRepository repository.CategoryRepository
	DB                 *sql.DB
	Validate           *validator.Validate
}

func (service *CategoryServiceImpl) Create(ctx context.Context, request web.CategoryCreateRequest) web.CategoryResponse {
	err := service.Validate.Struct(request)
	if err != nil {
		panic(err)
	}

	tx, err := service.DB.Begin()
	if err != nil {
		panic(err)
	}

	defer func() {
		err := recover()
		if err != nil {
			tx.Rollback()
		} else {
			tx.Commit()
		}
	}()

	category := domain.Category{
		Name: request.Name,
	}

	category = service.CategoryRepository.Store(ctx, tx, category)

	return web.CategoryResponse{
		Id:   category.Id,
		Name: category.Name,
	}

}

func (service *CategoryServiceImpl) Update(ctx context.Context, request web.CategoryUpdateRequest) web.CategoryResponse {
	err := service.Validate.Struct(request)
	if err != nil {
		panic(err)
	}

	tx, err := service.DB.Begin()
	if err != nil {
		panic(err)
	}

	defer func() {
		err := recover()
		if err != nil {
			tx.Rollback()
		} else {
			tx.Commit()
		}
	}()

	category, err := service.CategoryRepository.FindById(ctx, tx, request.Id)
	if err != nil {
		panic(err)
	}

	category.Name = request.Name

	category = service.CategoryRepository.Update(ctx, tx, category)

	return web.CategoryResponse{
		Id:   category.Id,
		Name: category.Name,
	}

}

func (service *CategoryServiceImpl) Delete(ctx context.Context, categoryId int) {
	tx, err := service.DB.Begin()
	if err != nil {
		panic(err)
	}

	defer func() {
		err := recover()
		if err != nil {
			tx.Rollback()
		} else {
			tx.Commit()
		}
	}()
	category, err := service.CategoryRepository.FindById(ctx, tx, categoryId)
	if err != nil {
		panic(err)
	}

	service.CategoryRepository.Delete(ctx, tx, category)
}

func (service *CategoryServiceImpl) FindById(ctx context.Context, categoryId int) web.CategoryResponse {
	tx, err := service.DB.Begin()
	if err != nil {
		panic(err)
	}

	defer func() {
		err := recover()
		if err != nil {
			tx.Rollback()
		} else {
			tx.Commit()
		}
	}()

	category, err := service.CategoryRepository.FindById(ctx, tx, categoryId)
	if err != nil {
		panic(err)
	}

	return web.CategoryResponse{
		Id:   category.Id,
		Name: category.Name,
	}
}

func (service *CategoryServiceImpl) FindAll(ctx context.Context) []web.CategoryResponse {
	tx, err := service.DB.Begin()
	if err != nil {
		panic(err)
	}

	defer func() {
		err := recover()
		if err != nil {
			tx.Rollback()
		} else {
			tx.Commit()
		}
	}()

	categories := service.CategoryRepository.FindAll(ctx, tx)
	var categoryResponses []web.CategoryResponse
	for _, category := range categories {
		categoryResponses = append(categoryResponses, web.CategoryResponse{
			Id:   category.Id,
			Name: category.Name,
		})
	}

	return categoryResponses
}
