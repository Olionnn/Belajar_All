import 'package:belajar_http_flutter/http_connection.dart';
import 'package:flutter/material.dart';

class AddAlbums extends StatefulWidget {
  const AddAlbums({super.key});

  @override
  State<AddAlbums> createState() => _AddAlbumsState();
}

class _AddAlbumsState extends State<AddAlbums> {
  final TextEditingController _titleController = TextEditingController();
  final TextEditingController _artistController = TextEditingController();
  final TextEditingController _priceController = TextEditingController();

  late Future<Response> addFutureAlbums;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Add Album"),
      ),
      body: Center(
        child: Padding(
            padding: const EdgeInsets.all(40.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                TextField(
                  controller: _titleController,
                  decoration: const InputDecoration(
                    border: UnderlineInputBorder(),
                    labelText: "Title",
                  ),
                ),
                TextField(
                  controller: _artistController,
                  decoration: const InputDecoration(
                    border: UnderlineInputBorder(),
                    labelText: "Artist",
                  ),
                ),
                TextField(
                  controller: _priceController,
                  keyboardType: TextInputType.number,
                  decoration: const InputDecoration(
                    border: UnderlineInputBorder(),
                    labelText: "Price",
                  ),
                ),
                const SizedBox(
                  height: 20,
                ),
                ElevatedButton(
                  onPressed: () {
                    final Album album = Album(
                      id: "0",
                      title: _titleController.text,
                      artist: _artistController.text,
                      price: double.parse(_priceController.text),
                    );
                    addFutureAlbums = addAlbum(album);
                    FutureBuilder<Response>(
                      future: addFutureAlbums,
                      builder: ((context, snapshot) {
                        if (snapshot.hasData) {
                          return const Scaffold(
                            body: SnackBar(
                              content: Text("Album Added!"),
                            ),
                          );
                        } else if (snapshot.hasError) {
                          return Text("Error: ${snapshot.error}");
                        }
                        return const CircularProgressIndicator();
                      }),
                    );
                    Future.delayed(const Duration(seconds: 2), () {
                      Navigator.pop(context, true);
                    });
                  },
                  child: const Text("Add Album"),
                ),
              ],
            )),
      ),
    );
  }
}
