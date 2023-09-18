import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Collapse from 'react-bootstrap/Collapse';
import ListGroup from 'react-bootstrap/ListGroup';
import Badge from 'react-bootstrap/Badge';
import Nav from 'react-bootstrap/Nav';

import './chat.css'


function OnlineList() {
    return (
    <div >
        <Card className='cbox'>
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
                    MEMANG BABI 
                    KAU DEKKKK 
                    WOIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII ASU
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
                    MEMANG BABI 
                    KAU DEKKKK 
                    WOIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII ASU
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
                        MEMANG BABI 
                        KAU DEKKKK 
                        WOIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII ASU
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
                        MEMANG BABI 
                        KAU DEKKKK 
                        WOIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII ASU
                        </div>
                        <Badge bg="primary" pill>
                        14
                        </Badge>
                    </ListGroup.Item>   
                </ListGroup> 
            </Card>
        </div>
    );
}

function InChat() {
    return (
        <h1>
            Inchat
        </h1>
    )
}

function Chat() {
    const [toggleState, setToggleState] = useState();
    return (
        <>
                <Card className='cbox'>
                
                    <div class="list-group">
                        <Button onClick={() => setToggleState(3)} >
                            
                            <div className='d-xl-flex'>
                                <img
                                        src="./logo.svg"
                                        width="40"
                                        height="40"
                                        className="d-inline-block rounded-circle"
                                        alt="React Bootstrap logo"
                                    />
                                    
                                <p className='my-auto'>Ardiansyah</p>
                                <p className=' mx-auto my-auto text me-5'>Online</p>
                                                    
                            </div>
                        </Button>
                        
                        <Button class="list-group-item list-group-item-action"> A second item</Button>
                        <Button class="list-group-item list-group-item-action"> A third Button item</Button>
                        <Button class="list-group-item list-group-item-action"> A fourth Button item</Button>
                        <Button class="list-group-item list-group-item-action" disabled> A disabled Button item</Button>

                    </div>
                </Card>
                <div hidden={toggleState === 3}>
                    <Card className='cbox'>
                        
                    </Card>
                                
                </div>
        </>

    )
}




export default function Chatbox() {
    const [open, setOpen] = useState(false);
    const [toggleState, setToggleState] = useState(1);
    return (
        <>
        <div className='fixed-bottom'>
            <div className='positon-relative'>
                
                <div style={{ minHeight: '200px', marginRight: '150px' }} className='position-absolute end-0 bottom-0 mb-3'>
                    <Collapse in={open} dimension="width">
                    <div id="example-collapse-text">
                        <Card >
                        <Card.Header className='wid'>
                            Chat Box
                        </Card.Header>
                            <div hidden={toggleState === 2}>
                                <OnlineList/>
                            </div>
                            <div hidden={toggleState === 1}>
                                <Chat>

                                </Chat>
                            </div>
                        <Card.Footer className='wid'>
                        <Nav fill variant="pills" defaultActiveKey="#">
                            <Nav.Item>
                                <Nav.Link onClick={() => setToggleState(1)}>Chat</Nav.Link>
                            </Nav.Item>
                            <Nav.Item>
                                <Nav.Link onClick={() => setToggleState(2)}>Online</Nav.Link>
                            </Nav.Item>
                        </Nav>
                        </Card.Footer>

                        </Card>


                    </div>
                    </Collapse>
                    
                </div>
            </div>

        </div>
        <div class="fixed-bottom bg-transparant">
            <div className='position-absolute end-0 bottom-0 my-3 mx-5'>
                
                <Button  
                onClick={() => setOpen(!open)}
                aria-controls="example-collapse-text"
                aria-expanded={open}>
                    <img src="/favicon.ico" alt="..." class="rounded-circle "/>
                </Button>
            </div>
        </div>


        </>
    );

}