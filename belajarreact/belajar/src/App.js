import React, { useContext } from "react";
import Login from "./pages/login/login";
import Register from "./pages/register/register";
import Home from "./pages/home/home";
import Profile from "./pages/profiles/profiles";
import { ThemeContext } from "./context/ThemeProvider";
import { Themes } from './context/Themes';
import Navi from "./component/navbar/navbar";

import Leftbar from "./component/leftbar/leftbar";
import Rightbar from "./component/rightbar/rightbar";
import Isinya from "./component/isimenu/isinya";
import { Container, Row, Col, } from "react-bootstrap";

import { BrowserRouter, Routes, Route } from "react-router-dom";
const getStyles = (mode) => ({
  app: {
    backgroundColor: Themes[mode].backgroundColor
  },
});



function App() {
  const { mode } = useContext(ThemeContext);
  const styles = getStyles(mode);

  return (
    <>
    <div style={styles.app}>
    <Navi/>
        <Container fluid className="d-fill-flex" >
          <Row>
            <Col xs={2} className="d-none d-xl-block">
              <Leftbar/>
            </Col>
            <Col className="position-sticky"> 
              <Routes>
                <Route index path="/" element={<Home />} />
                <Route path="/profile" element={<Profile />} />
              </Routes>
            </Col>
            <Col xs={2} className="col-xs-6 d-none d-xl-block">
              <Rightbar/>
            </Col>
          </Row>
        </Container>
    </div>
    </>
  );
}



export default App;
