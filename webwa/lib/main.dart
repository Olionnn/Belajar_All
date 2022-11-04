import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_keyboard_visibility/flutter_keyboard_visibility.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'WebWa',
      home: CScreen(),
    );
  }
}
// screen bot navbar
// class CScreen extends StatefulWidget {
//   const CScreen({super.key});

//   @override
//   State<CScreen> createState() => _CScreenState();
// }

// class _CScreenState extends State<CScreen> {
//   int pageIndex = 0;

//   final pages = [
//     const Home(),
//     const School(),
//     const Mail(),
//   ];
//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       backgroundColor: const Color(0xffC4DFCB),
//       appBar: AppBar(
//         leading: Icon(
//           Icons.menu,
//           color: Theme.of(context).primaryColor,
//         ),
//         title: Text(
//           "Geeks For Geeks",
//           style: TextStyle(
//             color: Theme.of(context).primaryColor,
//             fontSize: 25,
//             fontWeight: FontWeight.w600,
//           ),
//         ),
//         centerTitle: true,
//         backgroundColor: Colors.white,
//       ),
//       body: pages[pageIndex],
//       bottomNavigationBar: buildMyNavBar(context),
//     );
//   }

//   Container buildMyNavBar(BuildContext context) {
//     return Container(
//       height: 60,
//       decoration: BoxDecoration(
//         color: Theme.of(context).primaryColor,
//         borderRadius: const BorderRadius.only(
//           topLeft: Radius.circular(20),
//           topRight: Radius.circular(20),
//         ),
//       ),
//       child: Row(
//         mainAxisAlignment: MainAxisAlignment.spaceAround,
//         children: [
//           IconButton(
//             enableFeedback: false,
//             onPressed: () {
//               setState(() {
//                 pageIndex = 0;
//               });
//             },
//             icon: pageIndex == 0
//                 ? const Icon(
//                     Icons.home_filled,
//                     color: Colors.white,
//                     size: 35,
//                   )
//                 : const Icon(
//                     Icons.home_outlined,
//                     color: Colors.white,
//                     size: 35,
//                   ),
//           ),
//           IconButton(
//             enableFeedback: false,
//             onPressed: () {
//               setState(() {
//                 pageIndex = 1;
//               });
//             },
//             icon: pageIndex == 1
//                 ? const Icon(
//                     Icons.work_rounded,
//                     color: Colors.white,
//                     size: 35,
//                   )
//                 : const Icon(
//                     Icons.work_outline_outlined,
//                     color: Colors.white,
//                     size: 35,
//                   ),
//           ),
//           IconButton(
//             enableFeedback: false,
//             onPressed: () {
//               setState(() {
//                 pageIndex = 2;
//               });
//             },
//             icon: pageIndex == 2
//                 ? const Icon(
//                     Icons.widgets_rounded,
//                     color: Colors.white,
//                     size: 35,
//                   )
//                 : const Icon(
//                     Icons.widgets_outlined,
//                     color: Colors.white,
//                     size: 35,
//                   ),
//           ),
//           IconButton(
//             enableFeedback: false,
//             onPressed: () {
//               setState(() {
//                 pageIndex = 3;
//               });
//             },
//             icon: pageIndex == 3
//                 ? const Icon(
//                     Icons.person,
//                     color: Colors.white,
//                     size: 35,
//                   )
//                 : const Icon(
//                     Icons.person_outline,
//                     color: Colors.white,
//                     size: 35,
//                   ),
//           ),
//         ],
//       ),
//     );
//   }
// }

// Statetless Main
// class Home extends StatelessWidget {
//   const Home({super.key});

//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       appBar: AppBar(
//         title: const Text('WebWa'),
//       ),
//       body: const Center(child: Text('Home')),
//       floatingActionButton: FloatingActionButton(
//           child: Icon(Icons.cabin),
//           onPressed: () {
//             print('Asd');
//           }),
//       bottomNavigationBar: BottomNavigationBar(
//         type: BottomNavigationBarType.fixed,
//         selectedFontSize: 15,
//         unselectedFontSize: 10,
//         selectedItemColor: Colors.green,
//         unselectedItemColor: Colors.grey,
//         // onTap: _updateIndex,
//         // currentIndex: _currentIndex,
//         items: const [
//           BottomNavigationBarItem(
//             icon: Icon(Icons.home),
//             label: 'Home',
//           ),
//           BottomNavigationBarItem(
//             icon: Icon(Icons.school),
//             label: 'School',
//           ),
//           BottomNavigationBarItem(
//             icon: Icon(Icons.mail),
//             label: 'Mail',
//           ),
//         ],
//       ),
//       drawer: Drawer(
//         child: ListView(
//           children: [
//             ListTile(
//               leading: Icon(Icons.one_k),
//               title: Text('Nomor 1'),
//               onTap: () {
//                 print('Nomor 1');
//               },
//             ),
//             ListTile(
//               leading: Icon(Icons.two_k),
//               title: Text('Nomor 2'),
//               onTap: () {
//                 print('Nomor 2');
//               },
//             ),
//             ListTile(
//               leading: Icon(Icons.three_k),
//               title: Text('Nomor 3'),
//               onTap: () {
//                 print('Nomor 3');
//               },
//             ),
//           ],
//         ),
//       ),
//     );
//   }
// }

//keyboard up and down buttom
// class KeyboardUD extends StatefulWidget {
//   const KeyboardUD({super.key});

//   @override
//   State<KeyboardUD> createState() => _KeyboardUDState();
// }

// class _KeyboardUDState extends State<KeyboardUD> {
//   late FocusNode focusNode;

//   void initState(); {
//     super.initState();

//     focusNode = FocusNode();
//     focusNode.addListener(() {
//       print('Listener');
//     });
//   }

//   void dispose() {
//     focusNode.dispose();
//     super.dispose();
//   }

//   @override
//   Widget build(BuildContext context) {
//     return Container();
//   }
// }

// Home / Content Review
class CScreen extends StatefulWidget {
  const CScreen({super.key});

  @override
  State<CScreen> createState() => _CScreenState();
}

class _CScreenState extends State<CScreen> {
  // logic Home / Current View
  int _currentIndex = 0;
  List _screens = [Home(), School(), Mail()];

  void _updateIndex(int value) {
    setState(() {
      _currentIndex = value;
    });
  }

  // logic keyboard showing or not
  //showing
  FocusNode _focusNode = FocusNode();

  @override
  Widget build(BuildContext context) {
    // final bool isKeyboardVisible =
    //     KeyboardVisibilityProvider.isKeyboardVisible(context);
    return Scaffold(
      appBar: AppBar(
        title: const Text('WebWa'),
        actions: [
          // if (!)
          IconButton(onPressed: () {}, icon: const Icon(Icons.keyboard_alt)),
          IconButton(
              onPressed: () =>
                  SystemChannels.textInput.invokeMethod('TextInput.hide'),
              icon: const Icon(Icons.keyboard_alt_outlined)),
          PopupMenuButton(
              itemBuilder: (context) => [
                    PopupMenuItem(
                      child: Text('aa'),
                      value: Text('Permission'),
                      // onTap: () =>,
                    ),
                    PopupMenuItem(
                      child: Text('Terms Of Use'),
                      value: Text('Terms Of Use'),
                    ),
                    PopupMenuItem(
                      child: Text('Tutorial'),
                      value: Text('Tutorial'),
                    )
                  ])
        ],
      ),

      // body: const Center(child: Text('Home')),
      body: _screens[_currentIndex],
      floatingActionButton: FloatingActionButton(
          child: Icon(Icons.cabin),
          onPressed: () {
            print('Asd');
          }),
      bottomNavigationBar: BottomNavigationBar(
        type: BottomNavigationBarType.fixed,
        selectedFontSize: 15,
        unselectedFontSize: 10,
        selectedItemColor: Colors.green,
        unselectedItemColor: Colors.grey,
        onTap: _updateIndex,
        currentIndex: _currentIndex,
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Home',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.school),
            label: 'School',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.mail),
            label: 'Mail',
          ),
        ],
      ),
      drawer: Drawer(
        child: ListView(
          children: [
            ListTile(
              leading: Icon(Icons.one_k),
              title: Text('Nomor 1'),
              onTap: () {
                //update index value mulai dari 0
                _updateIndex(0);
              },
            ),
            ListTile(
              leading: Icon(Icons.two_k),
              title: Text('Nomor 2'),
              onTap: () {
                _updateIndex(1);
              },
            ),
            ListTile(
              leading: Icon(Icons.three_k),
              title: Text('Nomor 3'),
              onTap: () {
                _updateIndex(2);
              },
            ),
          ],
        ),
      ),
    );
  }
}

class Home extends StatelessWidget {
  const Home({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(
          child: TextButton(
              onPressed: () {
                print('Button Berjalan');
              },
              child: Text('Button'))),
    );
  }
}

class School extends StatelessWidget {
  const School({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(
        child: Text('sd'),
      ),
    );
  }
}

class Mail extends StatelessWidget {
  const Mail({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(
        child: const TextField(),
      ),
    );
  }
}
