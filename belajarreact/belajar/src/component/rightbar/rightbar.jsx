import { Card } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import ListGroup from 'react-bootstrap/ListGroup';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Badge from 'react-bootstrap/Badge';
import { getStyles } from '../../context/theming'
import { ThemeContext } from "../../context/ThemeProvider";
import React, { useState, useContext } from "react";


export default function Rightbar() {
    const { mode } = useContext(ThemeContext);
    const styles = getStyles(mode);
    return (
        <div className='valid'>
            <Container fluid className='mt-3 mr-4'>
                <Row>
                    <Col>
                        <Card style={styles.border}>
                            <Card.Header style={styles.postcard}>Mungkin Teman Anda?</Card.Header>
                            <ListGroup variant="flush" >
                                <ListGroup.Item style={styles.form}>
                                <Row xs="auto">
                                    <Col xs={2}><img
                                            src="./logo.svg"
                                            width="40"
                                            height="40"
                                            className="d-inline-block rounded-circle"
                                            alt="React Bootstrap logo"
                                            style={styles.iconbg}
                                        />  </Col>
                                    <Col xs={5}><p className='mt-2 ms-1'>Made in Ohio</p></Col>
                                    <Row>
                                        <Col md={{ span: 3, offset: 3 }}><Button style={styles.button} className='mt-2' size='sm'>Tambah</Button></Col>
                                    </Row>
                                </Row>
                                </ListGroup.Item>

                                <ListGroup.Item style={styles.form}>
                                <Row xs="auto">
                                    <Col xs={2}><img
                                            src="./logo.svg"
                                            width="40"
                                            height="40"
                                            className="d-inline-block rounded-circle"
                                            alt="React Bootstrap logo"
                                            style={styles.iconbg}
                                        />  </Col>
                                    <Col xs={5}><p className='mt-2 ms-1'>Raja EPEP</p></Col>
                                    <Row>
                                        <Col md={{ span: 3, offset: 3 }}><Button style={styles.button} className='mt-2' size='sm'>Tambah</Button></Col>
                                    </Row>
                                </Row> 
                                </ListGroup.Item>

                                <ListGroup.Item style={styles.form}>
                                <Row xs="auto">
                                    <Col xs={2}><img
                                            src="./logo.svg"
                                            width="40"
                                            height="40"
                                            className="d-inline-block rounded-circle"
                                            alt="React Bootstrap logo"
                                            style={styles.iconbg}
                                        />  </Col>
                                    <Col xs={5}><p className='mt-2 ms-1'>Hyskes cupo ...</p></Col>
                                    <Row>
                                        <Col md={{ span: 3, offset: 3 }}><Button style={styles.button} className='mt-2' size='sm'>Tambah</Button></Col>
                                    </Row>
                                </Row>
                                </ListGroup.Item>
                            </ListGroup>
                        </Card>
                        <br />
                        {/* <Card className='bg-black text-white border-primary'>
                            <Card.Header className='bg-black text-white border-primary'>Chat</Card.Header>
                            <ListGroup className='bg-black text-white border-primary'>
                                <a href='/#'>                                
                                    <ListGroup.Item
                                        className="d-flex justify-content-between align-items-start bg-black text-white "
                                    >
                                        <div className=''>
                                            <img
                                                src="./logo.svg"
                                                width="40"
                                                height="40"
                                                className="d-inline-block rounded-circle"
                                                alt="React Bootstrap logo"
                                            />
                                        </div>

                                        <div className="ms-2 me-auto">
                                            <div className="fw-bold">MOMOCHAN</div>
                                            IMAGE
                                        </div>
                                        <Badge bg="primary" pill>
                                        2
                                        </Badge>
                                        
                                    </ListGroup.Item>
                                </a>
                                <span class="border-bottom border-primary"></span>
                                <ListGroup.Item
                                    className="d-flex justify-content-between align-items-start bg-black text-white"
                                >
                                    <div className=''>
                                        <img
                                            src="./logo.svg"
                                            width="40"
                                            height="40"
                                            className="d-inline-block rounded-circle"
                                            alt="React Bootstrap logo"
                                        />
                                    </div>
                                    <div className="ms-2 me-auto">
                                        <div className="fw-bold">Paiho</div>
                                     PAhit susah
                                    </div>
                                    <Badge bg="primary" pill>
                                    14
                                    </Badge>
                                </ListGroup.Item>
                                <span class="border-bottom border-primary"></span>
                                <ListGroup.Item
                                    className="d-flex justify-content-between align-items-start bg-black text-white "
                                >
                                    <div className=''>
                                        <img
                                            src="./logo.svg"
                                            width="40"
                                            height="40"
                                            className="d-inline-block rounded-circle"
                                            alt="React Bootstrap logo"
                                        />
                                    </div>
                                    <div className="ms-2 me-auto">
                                        <div className="fw-bold">Tukimen</div>
                                        <p className='d-inline'>
                                            MEMANG BABI 
                                            KAU DEKKKK 
                                            WOIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII ASU
                                        </p>

                                    </div>
                                    <Badge bg="primary" pill>
                                        14
                                    </Badge>
                                </ListGroup.Item>
                            </ListGroup>    
                        </Card> */}
                    </Col>
                </Row>
            </Container>
        </div>
    );

}