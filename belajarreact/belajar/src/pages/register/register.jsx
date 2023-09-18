import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';  
import Card from 'react-bootstrap/Card';

export default function Register(){
    return(
        <>  
        <Card className='text-center position-absolute top-50 start-50 translate-middle' >
          <Card.Header className=''>Register</Card.Header>
          <Card.Body className=''>
            <Form>
                <Form.Group className="mb-3" controlId="formBasicUserName">
                    <Form.Label>Username</Form.Label>
                    <Form.Control type="text" placeholder="Enter Your Name" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>Email address</Form.Label>
                    <Form.Control type="email" placeholder="Enter email" />
                    <Form.Text className="text-muted">
                      We'll never share your email with anyone else.
                    </Form.Text>
                </Form.Group>

                <Form.Group className="mb-3" controlId="formBasicPassword">
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="password" placeholder="Password" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicCheckbox">
                    <Form.Check className='text-start' type="checkbox" label="Check me out" />
                </Form.Group>
                <Button   variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
          </Card.Body>

        </Card>
        </>
    );
}