package main

import "fmt"

type Barang struct {
	nama   string
	harga  int
	jumlah int
}

var BarangList []Barang

func TmbBarang() {

	var nama string
	var harga, jumlah int

	fmt.Println("Masukan Nama Barang: ")
	fmt.Scanln(&nama)
	fmt.Println("Masukan Harga Barang: ")
	fmt.Scanln(&harga)
	fmt.Println("Masukan Jumlah Barang: ")
	fmt.Scanln(&jumlah)
	BarangList = append(BarangList, Barang{nama: nama, harga: harga, jumlah: jumlah})
	fmt.Println("Barang Berhasil Ditambahkan")
}
func Hapus() {
	lihatData()
	var nama string
	fmt.Println("Masukan Nama Barang: ")
	fmt.Scanln(&nama)
	for i := 0; i < len(BarangList); i++ {
		if BarangList[i].nama == nama {
			BarangList = append(BarangList[:i], BarangList[i+1:]...)
		} else {
			fmt.Println("Barang Tidak Ditemukan")
		}
	}
	fmt.Println("Barang Berhasil Dihapus")
}

func EditBarang() {
	lihatData()
	var nama string
	var harga, jumlah int
	fmt.Println("Masukan Nama Barang: ")
	fmt.Scanln(&nama)

	for i := 0; i < len(BarangList); i++ {
		if BarangList[i].nama == nama {
			fmt.Println("Masukan Harga Barang: ")
			fmt.Scanln(&harga)
			fmt.Println("Masukan Jumlah Barang: ")
			fmt.Scanln(&jumlah)
			BarangList[i].harga = harga
			BarangList[i].jumlah = jumlah
			fmt.Println("Barang Berhasil Diubah")
		} else {
			fmt.Println("Barang Tidak Ditemukan")
		}
	}
}

func lihatData() {
	for _, Barang := range BarangList {
		fmt.Printf("NAMA : %v \n", Barang.nama)
		fmt.Printf("HARGA : %v \n", Barang.harga)
		fmt.Printf("JUMLAH : %v \n", Barang.jumlah)
		fmt.Println()
	}
}

func main() {
	for {
		fmt.Println("1. Tambah Barang")
		fmt.Println("2. Lihat Data Barang")
		fmt.Println("3. Edit Barang")
		fmt.Println("4. Hapus Barang")
		fmt.Println("5. Keluar")
		var pilih int
		fmt.Scanln(&pilih)
		switch pilih {
		case 1:
			TmbBarang()
		case 2:
			lihatData()
		case 3:
			EditBarang()
		case 4:
			Hapus()
		case 5:
			return
		default:
			fmt.Println("Pilihan Salah")
		}
		fmt.Println("Program Selesai")
	}
}
