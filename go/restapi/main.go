package main

import "gorestapi/service"

// func main() {
// 	mux := http.NewServeMux()
// 	addr := "http://localhost:8080"

// 	fmt.Println("Server Running...")
// 	fmt.Printf("Redirect : %s\n", addr)

// 	s := &http.Server{
// 		Addr:           "127.0.0.1:8080",
// 		Handler:        mux,
// 		ReadTimeout:    10 * time.Second,
// 		WriteTimeout:   10 * time.Second,
// 		MaxHeaderBytes: 1 << 20,
// 	}
// 	s.ListenAndServe()
// }

func main() {
	service.RunInt()
}
