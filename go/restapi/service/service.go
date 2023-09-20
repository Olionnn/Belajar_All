package service

import (
	"encoding/json"
	"fmt"
	"gorestapi/app/model"
	"os"
)

var dataFile = "data.json"

func GetAllUsers() ([]model.Users, error) {
	file, err := os.Open(dataFile)
	if err != nil {
		return []model.Users{}, err
	}
	defer file.Close()
	var users []model.Users
	json.NewDecoder(file).Decode(&users)
	return users, nil
}

func AddUser(user model.Users) error {
	file, err := os.OpenFile(dataFile, os.O_RDWR|os.O_CREATE, 0666)
	if err != nil {
		return err
	}
	defer file.Close()
	var users []model.Users
	json.NewDecoder(file).Decode(&users)
	users = append(users, user)
	json.NewEncoder(file).Encode(users)
	return nil
}

func DeleteUser(user *model.Users) error {
	file, err := os.OpenFile(dataFile, os.O_RDWR|os.O_CREATE, 0666)
	if err != nil {
		return err
	}
	defer file.Close()
	var users []model.Users
	json.NewDecoder(file).Decode(&users)
	for i, v := range users {
		if v.Id == user.Id {
			users = append(users[:i], users[i+1:]...)
		}
	}
	json.NewEncoder(file).Encode(users)
	return nil
}

func EditUser(user *model.Users) error {
	file, err := os.OpenFile(dataFile, os.O_RDWR|os.O_CREATE, 0666)
	if err != nil {
		return err
	}
	defer file.Close()
	var users []model.Users
	json.NewDecoder(file).Decode(&users)
	for i, v := range users {
		if v.Id == user.Id {
			users[i] = *user
			break
		}
	}
	json.NewEncoder(file).Encode(users)
	return nil
}

func RunInt() {
	pilih := 0
	fmt.Print("HLAMAN: ")
	fmt.Scanln(&pilih)
	for {
		switch pilih {
		case 1:
			users, err := GetAllUsers()
			if err != nil {
				panic(err)
			}
			for _, v := range users {
				fmt.Println(v)
			}
			break
		case 2:
			var user model.Users
			fmt.Print("Masukkan nama: ")
			fmt.Scanln(&user.Name)
			fmt.Print("Masukkan email: ")
			fmt.Scanln(&user.Email)
			fmt.Print("Masukkan password: ")
			fmt.Scanln(&user.Password)
			err := AddUser(user)
			if err != nil {
				panic(err)
			}
			break
		case 3:
			var user model.Users
			fmt.Print("Masukkan id: ")
			fmt.Scanln(&user.Id)
			fmt.Print("Masukkan nama: ")
			fmt.Scanln(&user.Name)
			fmt.Print("Masukkan email: ")
			fmt.Scanln(&user.Email)
			fmt.Print("Masukkan password: ")
			fmt.Scanln(&user.Password)
			err := EditUser(&user)
			if err != nil {
				panic(err)
			}
		case 4:

			var user model.Users
			fmt.Print("Masukkan id: ")
			fmt.Scanln(&user.Id)
			err := DeleteUser(&user)
			if err != nil {
				panic(err)
			}
		default:
			fmt.Print("SDDS")
		}
	}
}
