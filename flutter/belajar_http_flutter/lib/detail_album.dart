import 'package:flutter/material.dart';

class DetailAlbum extends StatefulWidget {
  final String? Title;
  final String? Artist;
  final double? Price;

  const DetailAlbum({super.key, this.Title, this.Artist, this.Price});

  @override
  State<DetailAlbum> createState() => _DetailAlbumState();
}

class _DetailAlbumState extends State<DetailAlbum> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Detail Album"),
      ),
      body: Center(
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Text("Title: ${widget.Title}"),
              Text("Artist: ${widget.Artist}"),
              Text("Price: ${widget.Price}"),
            ],
          ),
        ),
      ),
    );
  }
}
