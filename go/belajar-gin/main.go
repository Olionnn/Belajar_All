package main

import (
	"fmt"
	"net/http"
	"strconv"

	"github.com/gin-gonic/gin"
)

type Album struct {
	ID     string  `json:"id" form:"id"`
	Title  string  `json:"title" form:"title"`
	Artist string  `json:"artist" form:"artist"`
	Price  float64 `json:"price" form:"price"`
}

var albums = []Album{
	{ID: "1", Title: "Blue Train", Artist: "John Coltrane", Price: 56.99},
	{ID: "2", Title: "Jeru", Artist: "Gerry Mulligan", Price: 17.99},
	{ID: "3", Title: "Sarah Vaughan and Clifford Brown", Artist: "Sarah Vaughan", Price: 39.99},
}

func getAlbums(c *gin.Context) {
	c.IndentedJSON(http.StatusOK, albums)
}

func addAlbums(c *gin.Context) {
	var newAlbums Album

	if err := c.ShouldBind(&newAlbums); err != nil {
		fmt.Println(err.Error())
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}

	albums = append(albums, newAlbums)
	c.JSON(http.StatusCreated, newAlbums)
}

func updateAlbums(c *gin.Context) {
	id := c.Param("id")
	idInt, err := strconv.Atoi(id)
	if err != nil {
		c.JSON(http.StatusBadRequest, gin.H{"error": "Invalid ID"})
		return
	}

	var updatedAlbum Album
	if err := c.ShouldBind(&updatedAlbum); err != nil {
		fmt.Println(err.Error())
		c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
		return
	}

	if updatedAlbum.ID == "" {
		updatedAlbum.ID = albums[idInt-1].ID
	}

	if updatedAlbum.Artist == "" {
		updatedAlbum.Artist = albums[idInt-1].Artist
	}

	if updatedAlbum.Title == "" {
		updatedAlbum.Title = albums[idInt-1].Title
	}

	if updatedAlbum.Price == 0 {
		updatedAlbum.Price = albums[idInt-1].Price
	}
	albums[idInt-1] = updatedAlbum

	c.JSON(http.StatusOK, updatedAlbum)
}

func getAlbumsByID(c *gin.Context) {
	id := c.Param("id")

	for _, a := range albums {
		if a.ID == id {
			c.IndentedJSON(http.StatusOK, a)
			return
		}
	}
	c.IndentedJSON(http.StatusNotFound, gin.H{"message": "album not found"})
}

func deleteAlbums(c *gin.Context) {
	id := c.Param("id")

	for i, a := range albums {
		if a.ID == id {
			c.IndentedJSON(http.StatusOK, a)
			albums = append(albums[:i], albums[i+1:]...)
			return
		}
	}
	c.IndentedJSON(http.StatusNotFound, gin.H{"message": "album not found"})
}

func main() {
	r := gin.Default()

	r.GET("/albums", getAlbums)
	r.GET("/albums/:id", getAlbumsByID)
	r.POST("/albums", addAlbums)
	r.PUT("/albums/:id", updateAlbums)
	r.DELETE("/albums/:id", deleteAlbums)

	r.Run("localhost:8080")
}
