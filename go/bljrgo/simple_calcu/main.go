package main

import "fmt"

func Tambah(a, b int) int {
	return a + b
}
func Kurang(a, b int) int {
	return a - b
}
func kali(a, b int) int {
	return a * b
}

func main() {
	for {
		fmt.Println("1. Tambah")
		fmt.Println("2. Kurang")
		fmt.Println("3. Kali")
		fmt.Println("4. Keluar")
		var pilih int
		var a, b int
		fmt.Print("Masukan Pilihan: ")
		fmt.Scan(&pilih)
		switch pilih {
		case 1:
			fmt.Print("Masukan Angka: ")
			fmt.Scan(&a)
			fmt.Print("Masukan Angka: ")
			fmt.Scan(&b)
			result := Tambah(a, b)
			fmt.Printf("Hasilnya : %v\n", result)
		case 2:
			fmt.Print("Masukan Angka: ")
			fmt.Scan(&a)
			fmt.Print("Masukan Angka: ")
			fmt.Scan(&b)
			result := Kurang(a, b)
			fmt.Printf("Hasilnya : %v\n", result)
		case 3:
			fmt.Print("Masukan Angka: ")
			fmt.Scan(&a)
			fmt.Print("Masukan Angka: ")
			fmt.Scan(&b)
			result := kali(a, b)
			fmt.Printf("Hasilnya : %v\n", result)
		case 4:
			return
		default:
			fmt.Println("Pilihan salah")
		}
	}
}
