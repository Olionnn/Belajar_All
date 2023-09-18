import Card from 'react-bootstrap/Card';
import { ThemeContext } from '../../context/ThemeProvider';
import { getStyles } from '../../context/theming'
import Button from 'react-bootstrap/Button'; 
import React, { useState,useContext } from 'react';
import Nav from 'react-bootstrap/Nav';
import { Container } from 'react-bootstrap';

import Isinya from "../../component/isimenu/isinya";
function Posts() {
    return(
    <>
    <Card.Body >
        <Card.Text>
            Posts
        </Card.Text>
    </Card.Body>
    </>
);
}

function Likes() {
   return(
    <>
    <Card.Body>
        <Card.Text>
            Likes
        </Card.Text>
    </Card.Body>
    </>
   ); 
}
function Biodata() {
   return(
    <>
    <Card.Body>
        <Card.Text>
            Bio
        </Card.Text>
    </Card.Body>
    </>
   ); 
}

function Media() {
    return(
    <>
    <Card.Body className=''>
        <Card.Text>
            Media
        </Card.Text>
    </Card.Body>    
    </>
    );
}


export default function Profile(){
    const { mode } = useContext(ThemeContext);
    const styles = getStyles(mode);
    const [menu , togglemenu] = useState("1");
    return(
    <>
    <div style={ styles.fullscreen }>
    <Container fluid >
            <Card  className='mt-4'  style={ styles.box }>
                <Card.Header className='mt-1' style={ styles.border }>
                    <Card.Img variant="top" src="./saas.jpg" height={400} width={1102} style={ styles.iconbg }/>
                    <div>
                        <img className='position-absolute top-90 start-50 translate-middle mt-2' style={ styles.iconbg } src='./logo.svg' height={100} width={100}/>
                    </div> 
                </Card.Header>

                <br />
                <br />

                    <Nav fill  variant="pills" defaultActiveKey="#Posts" style={ styles.cbox }>
                        <Nav.Item>
                            <Nav.Link style={ styles.button }  onClick={() => togglemenu("1")} href="#Biodata">Biodata</Nav.Link>
                        </Nav.Item>
                        <Nav.Item>
                            <Nav.Link style={ styles.button } onClick={() => togglemenu("2")} href="#Posts">Posts</Nav.Link>
                        </Nav.Item>
                        <Nav.Item>
                            <Nav.Link style={ styles.button } onClick={() => togglemenu("3")} href="#Likes">Likes</Nav.Link>
                        </Nav.Item>
                        <Nav.Item>
                            <Nav.Link style={ styles.button } onClick={() => togglemenu("4")} href="#Media">Media</Nav.Link>
                        </Nav.Item>
                    </Nav>


                <Card.Body style={ styles.text }>
                    {menu === "1" && <Biodata></Biodata>}
                    {menu === "2" && <Posts></Posts>}
                    {menu === "3" && <Likes></Likes>}
                    {menu === "4" && <Media></Media>}
                </Card.Body>
            </Card>
        </Container>

    </div>
    </>
    );
}