import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import './navbar.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Collapse from 'react-bootstrap/Collapse';
import React, { useState, useContext } from "react";
import Offcanvas from 'react-bootstrap/Offcanvas';
import ThemeSwitch from '../cswitch/themeswitch';
import { getStyles } from '../../context/theming'
import { ThemeContext } from "../../context/ThemeProvider";
import { Link, useNavigate } from "react-router-dom";
import CloseButton from 'react-bootstrap/CloseButton';



function Navi() {
  const navigate = useNavigate();
  const [open, setOpen] = useState(false);
  const { mode } = useContext(ThemeContext);
  const styles = getStyles(mode);

  return (
    <>
      {['md'].map((expand) => (  
        <Navbar key={expand} expand={expand} style={styles.navbar}>
          <Container>
            <Navbar.Brand onClick={()=> navigate('/profile')}>
              <img
                src="./logo.svg"
                width="35"
                height="35"
                className="d-inline-block align-top"
                alt="React Bootstrap logo"
                style={styles.iconbg}
              />
            </Navbar.Brand>
              <Nav className="justify-content-end flex-grow-1 pe-3" activeKey="/home">
                <div className="d-none d-sm-block d-sm-none d-md-block">
                  <Form className="d-flex " >
                      <Button
                          onClick={() => setOpen(!open)}
                          aria-controls="example-collapse-text"
                          aria-expanded={open}
                          size='sm-1'
                          variant="outline-light"
                          className='space'
                          style={styles.button}
                        >
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="21" style={styles.text} class="bi bi-search" viewBox="0 3 23 18">
                          <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                        </svg>
                      </Button>
                      <div style={{ minHeight: '20px' }}>
                        <Collapse in={open} dimension="width">
                          <div id="example-collapse-text">
                            <div className='top'>
                              <Form.Control style={{ width: '300px' }} className='nobrd' placeholder='Search'></Form.Control>
                            </div>


                          </div>
                        </Collapse>
                      </div>
                      <Nav.Item style={{ marginRight: '-9px' }} >
                      <Nav.Link onClick={()=> navigate('/')}>
                        <Button variant='outline-light' size='sm' style={styles.button}> 
                          Home 
                        </Button> 
                      </Nav.Link>
                    </Nav.Item>

                    <Nav.Item style={{ marginRight: '-9px' }}>
                      <Nav.Link eventKey="link-1" href="/home">
                        <Button variant='outline-light' size='sm' style={styles.button}>
                          Informan
                        </Button> 
                      </Nav.Link>
                    </Nav.Item>

                    <Nav.Item style={{ marginRight: '-9px' }}>
                      <Nav.Link eventKey="link-2">
                        <Button variant='outline-light' size='sm' style={styles.button}>
                          Friends
                        </Button> 
                      </Nav.Link>
                    </Nav.Item>
                  </Form>
                </div>
              </Nav>
          
            <Navbar.Toggle aria-controls="responsive-navbar-nav" style={styles.ofcanvasbutton} />
            <div className='d-block d-sm-none'>
              <Navbar.Offcanvas 
                id={`offcanvasNavbar-expand-${expand}`}
                aria-labelledby={`offcanvasNavbar-expand-${expand}`}
                placement="end" 
                >
                <Offcanvas.Header closeButton closeVariant="white" style={styles.theme} >
                  <Offcanvas.Title  id={`offcanvasNavbarLabel-expand-${expand}`} style={styles.text}>
                    Menu
                  </Offcanvas.Title>
                </Offcanvas.Header>
                <Offcanvas.Body style={styles.theme}>              
                  <Form className="d-flex">
                    <Button
                        onClick={() => setOpen(!open)}
                        aria-controls="example-collapse-text"
                        aria-expanded={open}
                        size='md'
                        variant="outline-light"
                        className='space'
                        style={styles.inofcanvabutton}
                      >
                      <svg xmlns="http://www.w3.org/2000/svg" width="20" height="21" style={styles.text} class="bi bi-search" viewBox="0 3 23 18">
                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                      </svg>
                    </Button>
                    <div style={{ minHeight: '20px' }}>
                      <Collapse in={open} dimension="width">
                        <div id="example-collapse-text">
                          <div className='top'>
                            <Form.Control style={{ width: '300px' }} className='nobrd' placeholder='Search'></Form.Control>
                          </div>
                        </div>
                      </Collapse>
                    </div>
                  </Form>
                  <br />
              
                  <Nav.Item style={{ marginRight: '-9px' }} >
                    <Nav.Link href="/" className='d-grid '>
                      <Button style={styles.inofcanvabutton}  size='md'> 
                        Home 
                      </Button> 
                    </Nav.Link>
                  </Nav.Item>

                  <br />
                  <Nav.Item style={{ marginRight: '-9px' }} >
                    <Nav.Link eventKey="link-1" href="/home" className='d-grid ' >
                      <Button style={styles.inofcanvabutton} size='md'>
                        Informan
                      </Button> 
                    </Nav.Link>
                  </Nav.Item>

                  <br />
                  <Nav.Item style={{ marginRight: '-9px' }}>
                    <Nav.Link eventKey="link-2"  className='d-grid '> 
                      <Button style={styles.inofcanvabutton} size='md'>
                        Friends
                      </Button> 
                    </Nav.Link>
                  </Nav.Item>
                  <br />
                  <Nav.Item style={{ marginRight: '-9px' }}>
                    <Nav.Link eventKey="link-2" className='d-grid '>
                      <Button style={styles.inofcanvabutton} size='md'>
                        Setting
                      </Button> 
                    </Nav.Link>
                  </Nav.Item>
                  <br />
                  <Nav.Item style={{ marginRight: '-9px' }}>
                      <ThemeSwitch></ThemeSwitch>
                  </Nav.Item>

                  <Nav.Item style={{ marginRight: '-9px' }}>
                    <Nav.Link eventKey="link-2" className='d-grid '>
                      <Button style={styles.inofcanvabutton} size='md'>
                        Account
                      </Button> 
                    </Nav.Link>
                  </Nav.Item>
                </Offcanvas.Body>
              </Navbar.Offcanvas>
            </div>
          </Container>
        </Navbar>
      ))}

    </>
  );
}

export default Navi;