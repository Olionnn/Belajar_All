import { Card } from 'react-bootstrap';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';
import Stack from 'react-bootstrap/Stack';
import Form from 'react-bootstrap/Form';
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import './isinya.css'
import React, { useState, useContext } from "react";
import { getStyles } from '../../context/theming'
import { ThemeContext } from "../../context/ThemeProvider";
import Dropdown from 'react-bootstrap/Dropdown';
import DropdownButton from 'react-bootstrap/DropdownButton';

function Isinya(){
  const { mode } = useContext(ThemeContext);
  const styles = getStyles(mode);
    return(
      <Container fluid>
        <Row>
          <Col>
            <Card className="mt-4 mb-3" style={styles.box}>
              <Card.Body>
                <div className='d-xxl-none d-xl-none d-xxl-block '>
                  <Card style={styles.border}>    
                    <Card.Body style={styles.cbox}> 
                        <Stack direction="vertical" gap={1}>  
                          <Form.Group className="mb-3" controlId="">
                              <img
                                  src="./logo.svg"
                                  width="40"
                                  height="40"
                                  className="d-inline-block rounded-circle me-1 mb-1 "
                                  alt="React Bootstrap logo"
                                  style={styles.iconbg}
                              />
                              <Form.Label style={styles.text}>Upload Status</Form.Label>

                              <Form.Control as="textarea" rows={3} style={styles.form}/>
                          </Form.Group>

                          </Stack>
                        <ButtonGroup size="sm" className='position-absolute top-1 end-1'>
                            <Button style={styles.button}>Upload Image</Button>
                            <Button style={styles.button}>Setting</Button>
                            <Button style={styles.button}>Post</Button>
                      </ButtonGroup>
                    </Card.Body>
                  </Card>
                  <br />
                </div>

                <Card style={styles.postcard}>
                  <Card.Header style={styles.border}>
                    <Stack direction="horizontal" gap={2}>
                      <img
                        src="./logo.svg"
                        width="40"
                        height="40"
                        className="d-inline-block rounded-circle"
                        alt="React Bootstrap logo"
                        style={styles.iconbg}
                      />
                      <Stack direction="vertical" gap={1}>  
                      <p className='nama'>Ardiansyah Al Cahya Maulana</p>
                      <p className='tanggal'>2 days ago</p>
                      </Stack>


                      <div className="vr ms-auto bg-light" />
                        <Dropdown>
                          <Dropdown.Toggle style={styles.postcard}>
                          </Dropdown.Toggle>

                          <Dropdown.Menu style={styles.button}>
                            <Dropdown.Item style={styles.text} href="#/action-1">Edit</Dropdown.Item>
                            <Dropdown.Item style={styles.text} href="#/action-2">Not Intresting</Dropdown.Item>
                            <Dropdown.Item style={styles.text} href="#/action-3">Share</Dropdown.Item>
                          </Dropdown.Menu>
                        </Dropdown>


                    </Stack>

                  </Card.Header>
                  <Card.Body>
                    <Card.Title>                    
                      <img
                        src="./logo.svg"
                        width="200"
                        height="200"
                        className="img-fluid"
                        alt="React Bootstrap logo"
                      /></Card.Title>
                    <Card.Text className=''>
                      YUHUUUU AKU BELAJAR REACT CUYYY
                    </Card.Text>
                  </Card.Body>
                  <Card.Footer className="text-muted">Comment<br/> .....</Card.Footer>
                </Card>

                <br />
                <Card style={styles.postcard}>
                  <Card.Header style={styles.border}>
                    <Stack direction="horizontal" gap={2}>
                      <img
                        src="./logo.svg"
                        width="40"
                        height="40"
                        className="d-inline-block rounded-circle "
                        alt="React Bootstrap logo"
                        style={styles.iconbg}
                      />
                      <Stack direction="vertical" gap={1}>  
                      <p className='nama'>Udin Pentok</p>
                      <p className='tanggal'>2 days ago</p>
                      </Stack>
                      
                      <div className="vr ms-auto bg-light" />
                      <Dropdown>
                        <Dropdown.Toggle style={styles.postcard}>
                        </Dropdown.Toggle>

                        <Dropdown.Menu style={styles.button}>
                          <Dropdown.Item style={styles.text} href="#/action-1">Edit</Dropdown.Item>
                          <Dropdown.Item style={styles.text} href="#/action-2">Not Intresting</Dropdown.Item>
                          <Dropdown.Item style={styles.text} href="#/action-3">Share</Dropdown.Item>
                        </Dropdown.Menu>
                      </Dropdown>

                    </Stack>

                  </Card.Header>
                  <Card.Body>
                    <Card.Title></Card.Title>
                    <Card.Text>
                      Selamat Menjalankan Ibadah Puasa
                    </Card.Text>
                  </Card.Body>
                  <Card.Footer className="text-muted">Comment <br/> .....</Card.Footer>
                </Card>
                <br />
                <Card style={styles.postcard}>
                  <Card.Header style={styles.border}>
                    <Stack direction="horizontal" gap={2}>
                      <img
                        src="./saas.jpg"
                        width="40"
                        height="40"
                        className="d-inline-block rounded-circle"
                        alt="React Bootstrap logo"
                        style={styles.iconbg}
                      />
                      <Stack direction="vertical" gap={1}>  
                        <p className='nama '>Mamang Rekok</p>
                        <p className='tanggal '>2 days ago</p>
                      </Stack>
                      <div className="vr ms-auto bg-light" />
                      <Dropdown>
                          <Dropdown.Toggle style={styles.postcard}>
                          </Dropdown.Toggle>

                          <Dropdown.Menu style={styles.button}>
                            <Dropdown.Item style={styles.text} href="#/action-1">Edit</Dropdown.Item>
                            <Dropdown.Item style={styles.text} href="#/action-2">Not Intresting</Dropdown.Item>
                            <Dropdown.Item style={styles.text} href="#/action-3">Share</Dropdown.Item>
                          </Dropdown.Menu>
                      </Dropdown>

                    </Stack>

                  </Card.Header>
                  <Card.Body>
                    <Card.Title>
                      <img
                        src="./saas.jpg"
                        width="300"
                        height="300"
                        className="d-inline-block img-fluid"
                        alt="React Bootstrap logo"
                      />
                    </Card.Title>
                    <Card.Text className=''>
                      Aku Kesepian NIH
                    </Card.Text>
                  </Card.Body>
                  <Card.Footer className="text-muted">Comment <br/> .....</Card.Footer>
                </Card>
              </Card.Body>
            </Card>
          </Col>
        </Row>
    </Container>
    );
}


export default Isinya;