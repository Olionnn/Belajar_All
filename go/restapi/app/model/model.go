package model

type Users struct {
	Id       int    `json:"id"`
	Name     string `json:"name"`
	Email    string `json:"email"`
	Password string `json:"password"`
}

type Books struct {
	Id        int    `json:"id"`
	Name      string `json:"name"`
	Author    string `json:"author"`
	Publisher string `json:"publisher"`
	Price     int    `json:"price"`
	Stock     int    `json:"stock"`
}

type Subscription struct {
	Id     int `json:"id"`
	UserId int `json:"userId"`
	BookId int `json:"bookId"`
	Status int `json:"status"`
}
