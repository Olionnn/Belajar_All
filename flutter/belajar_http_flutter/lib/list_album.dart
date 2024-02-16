import 'package:belajar_http_flutter/add_albums.dart';
import 'package:belajar_http_flutter/detail_album.dart';
import 'package:flutter/material.dart';
import 'package:belajar_http_flutter/http_connection.dart';

class ListAlbum extends StatefulWidget {
  ListAlbum({super.key});

  @override
  State<ListAlbum> createState() => _ListAlbumState();
}

class _ListAlbumState extends State<ListAlbum> {
  late Future<List<Album>> futureAlbums;

  @override
  void initState() {
    super.initState();
    futureAlbums = fetchAlbums();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Flutter Http"),
      ),
      body: FutureBuilder<List<Album>>(
        future: futureAlbums,
        builder: ((context, snapshot) {
          if (snapshot.hasData) {
            return ListView.builder(
              itemCount: snapshot.data!.length,
              itemBuilder: (context, index) {
                final album = snapshot.data![index];
                return Card(
                  child: ListTile(
                    title: Text(album.title),
                    subtitle: Text(album.artist),
                    onTap: () {
                      _onTapDetails(context, album);
                    },
                    onLongPress: () {
                      _longPressDelete(context, album);
                    },
                  ),
                );
              },
            );
          } else if (snapshot.hasError) {
            return Center(
              child: Text('Error: ${snapshot.error}'),
            );
          }
          return const Center(
            child: CircularProgressIndicator(),
          );
        }),
      ),
      floatingActionButtonLocation: FloatingActionButtonLocation.endFloat,
      floatingActionButton: FloatingActionButton(
        onPressed: () async {
          await _onPressAdd(context);
        },
        child: const Icon(Icons.add),
      ),
    );
  }

  Future<void> _onPressAdd(BuildContext context) async {
    await Navigator.push(
      context,
      MaterialPageRoute(
        builder: (context) => const AddAlbums(),
      ),
    );
    
    setState(() {
      futureAlbums = fetchAlbums();
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(
          content: Text("Album Added!"),
        ),
      );
    });
  }

  void _onTapDetails(BuildContext context, Album album) {
    Navigator.push(
      context,
      MaterialPageRoute(
        builder: (context) => DetailAlbum(
          Title: album.title,
          Artist: album.artist,
          Price: album.price,
        ),
      ),
    );
  }

  Future<dynamic> _longPressDelete(BuildContext context, Album album) {
    return showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: const Text("Delete Album"),
          content: Text("Are you sure want to delete ${album.title}?"),
          actions: <Widget>[
            TextButton(
              onPressed: () {
                Navigator.pop(context);
              },
              child: const Text("Cancel"),
            ),
            TextButton(
              onPressed: () {
                Navigator.pop(context);
                setState(() {
                  deleteAlbum(album.id);
                  futureAlbums = fetchAlbums();
                });
              },
              child: const Text("Delete"),
            ),
          ],
        );
      },
    );
  }
}
