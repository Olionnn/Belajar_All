import 'dart:convert';
import 'dart:async';
import 'dart:math';

import 'package:http/http.dart' as http;

class Album {
  final String id;
  final String title;
  final String artist;
  final double price;

  const Album({
    required this.id,
    required this.title,
    required this.artist,
    required this.price,
  });

  factory Album.fromJson(Map<String, dynamic> json) {
    return Album(
      id: json['id'] as String,
      title: json['title'] as String,
      artist: json['artist'] as String,
      price: (json['price'] as num).toDouble(),
    );
  }
}

class Response {
  final int statusCode;
  final String body;

  const Response({
    required this.statusCode,
    required this.body,
  });
}

/// Cuma Dapet Data Akhir
Future<Album> fetchAlbum() async {
  final response = await http.get(Uri.parse('http://10.0.2.2:8080/albums'));

  if (response.statusCode == 200) {
    final List<dynamic> data = jsonDecode(response.body);

    if (data.isNotEmpty) {
      // print("${response.body}");
      return Album.fromJson(data.first as Map<String, dynamic>);
    } else {
      throw Exception('No album data found');
    }
  } else {
    throw Exception('Failed to load album');
  }
}

/// Dapet Semua Data Jadi List
Future<List<Album>> fetchAlbums() async {
  final response = await http.get(Uri.parse('http://192.168.6.20:8080/albums'));

  if (response.statusCode == 200) {
    final List<dynamic> data = jsonDecode(response.body);
    final List<Album> albums =
        data.map((item) => Album.fromJson(item)).toList();
    return albums;
  } else {
    throw Exception('Failed to load albums');
  }
}

/// Tambah Album Ke API
Future<Response> addAlbum(Album album) async {
  final response = await http.post(
    Uri.parse('http://192.168.6.20:8080/albums'),
    headers: <String, String>{
      'Content-Type': 'application/json; charset=UTF-8',
    },
    body: jsonEncode(<String, dynamic>{
      'id': Random().nextInt(100).toString(),
      'title': album.title,
      'artist': album.artist,
      'price': album.price,
    }),
  );

  return Response(
    statusCode: response.statusCode,
    body: response.body,
  );
}

/// Delete Album dari API
Future<Response> deleteAlbum(String id) async {
  final response = await http.delete(
    Uri.parse('http://192.168.6.20:8080/albums/$id'),
  );

  return Response(
    statusCode: response.statusCode,
    body: response.body,
  );
}



// void main() {
//   late Future<Album> futureAlbum = fetchAlbum();

//   futureAlbum.then((album) {
//     print(album.id);
//     print(album.title);
//     print(album.artist);
//     print(album.price);
//   }).catchError((error) {
//     print(error);
//   });
// }
