import { Card } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Stack from 'react-bootstrap/Stack';
import ListGroup from 'react-bootstrap/ListGroup';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import "./leftbar.css";
import React, { useState, useContext } from "react";
import { getStyles } from '../../context/theming';
import { ThemeContext } from "../../context/ThemeProvider";


export default function Leftbar() {
    const { mode } = useContext(ThemeContext);
    const styles = getStyles(mode);
    return (
        <div className='valid'>
            <Container fluid className='mt-3' >
                <Row >
                    <Col>
                        <Card style={styles.border}>
                            
                            <Card.Body style={styles.box}>
                                <Card style={styles.border}>
                                    <Card.Header style={styles.postcard}>Group List</Card.Header>     
                                    <ListGroup variant="flush " >
                                        <a href='#' style={{ textDecorationLine: 'none' }}><ListGroup.Item style={styles.postcard}>Group Keluarga</ListGroup.Item></a>
                                        <a href='#' style={{ textDecorationLine: 'none' }}><ListGroup.Item style={styles.postcard}>Group Tahan Tawa</ListGroup.Item></a>
                                        <a href='#' style={{ textDecorationLine: 'none' }}><ListGroup.Item style={styles.postcard}>Gila Comunity</ListGroup.Item></a>
                                        <a href='#' style={{ textDecorationLine: 'none' }}><ListGroup.Item style={styles.postcard}>Jual Beli Helicopter</ListGroup.Item></a>
                                    </ListGroup>
                                </Card>
                            </Card.Body>
                        </Card>
                    
                    <br />
                    
                        <Card  style={styles.border}>
                            
                            <Card.Body  style={styles.box}> 
                                <Stack direction="vertical" gap={1}>  
                                <Form.Group className="mb-3" controlId="">
                                    <img
                                        src="./logo.svg"
                                        width="40"
                                        height="40"
                                        className="d-inline-block rounded-circle me-1 mb-1"
                                        alt="React Bootstrap logo"
                                        style={styles.iconbg}
                                    />
                                    <Form.Label  style={styles.text}>Upload Status</Form.Label>

                                    <Form.Control as="textarea" rows={3}  style={styles.postcard}/>
                                </Form.Group>

                                </Stack>
                                <ButtonGroup size="sm"  >
                                    <Button style={styles.button}>Add Photos</Button>
                                    <Button style={styles.button}>Setting</Button>
                                    <Button style={styles.button}>Post</Button>
                                </ButtonGroup>
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
            </Container>
        </div>
    );
}