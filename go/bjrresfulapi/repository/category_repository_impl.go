package repository

import (
	"bjrresfulapi/model/domain"
	"context"
	"database/sql"
)

type CategoryRepositoryImpl struct {
}

func (repository *CategoryRepositoryImpl) FindById(ctx context.Context, tx *sql.Tx, categoryId int) (domain.Category, error) {
	SQL := "SELECT id, name FROM categories WHERE id = ?"
	row, err := tx.QueryContext(ctx, SQL, categoryId)
	if err != nil {
		return domain.Category{}, err
	}

	category := domain.Category{}
	if row.Next() {
		err = row.Scan(&category.Id, &category.Name)
		if err != nil {
			return domain.Category{}, err
		}
		return category, nil
	} else {
		return domain.Category{}, nil
	}
}

func (repository *CategoryRepositoryImpl) FindAll(ctx context.Context, tx *sql.Tx) []domain.Category {
	SQL := "SELECT id, name FROM categories"
	rows, err := tx.QueryContext(ctx, SQL)
	if err != nil {
		panic(err)
	}

	defer rows.Close()
	var categories []domain.Category
	for rows.Next() {
		category := domain.Category{}
		err = rows.Scan(&category.Id, &category.Name)
		if err != nil {
			panic(err)
		}
		categories = append(categories, category)
	}

	return categories
}

func (repository *CategoryRepositoryImpl) Store(ctx context.Context, tx *sql.Tx, category domain.Category) domain.Category {
	SQL := "INSERT INTO categories(name) VALUES(?)"
	result, err := tx.ExecContext(ctx, SQL, category.Name)
	if err != nil {
		panic(err)
	}

	id, err := result.LastInsertId()
	if err != nil {
		panic(err)
	}

	category.Id = int(id)
	return category
}

func (repository *CategoryRepositoryImpl) Update(ctx context.Context, tx *sql.Tx, category domain.Category) domain.Category {
	SQL := "UPDATE categories SET name = ? WHERE id = ?"
	_, err := tx.ExecContext(ctx, SQL, category.Name, category.Id)
	if err != nil {
		panic(err)
	}

	return category
}

func (repository *CategoryRepositoryImpl) Delete(ctx context.Context, tx *sql.Tx, category domain.Category) {
	SQL := "DELETE FROM categories WHERE id = ?"
	_, err := tx.ExecContext(ctx, SQL, category.Id)
	if err != nil {
		panic(err)
	}

}
