import React from 'react'
import { Link, BrowserRouter } from 'react-router-dom';
import { MDBCol, MDBContainer, MDBRow, MDBFooter } from "mdbreact";
import { Form, Button } from 'react-bootstrap'
import logo from "./logo.png"
import './Footer.css'
import { SocialIcon } from 'react-social-icons';
const Footer = () => {
    return (
        
            <MDBFooter color="blue-grey" className="page-footer font-small lighten-5 pt-0 ">
                <div >
                    <MDBContainer>
                        <MDBRow className="py-4 d-flex align-items-center">
                        <MDBCol md="6" lg="4" className="text-center text-md-left mb-4 mb-md-0">
                                <h6 className="mb-0 " style={{ color: "white" }}> Get connected with us on social networks!</h6>
                            </MDBCol>
                        <MDBCol md="6" lg="8" className="text-center text-md-right">
                                <Link to="/" className="tw-ic ml-0">
                                 <SocialIcon url="https://twitter.com/" />
                                 <>{"\u00a0\u00a0"}</>
                                </Link>
                                <Link to="/" className="fb-ic">
                                <SocialIcon url="https://facebook.com/" />
                                <>{"\u00a0\u00a0"}</>
                                </Link>
                                <Link to="/" className="li-ic">
                                <SocialIcon url="https://linkedin.com/" />
                                <>{"\u00a0\u00a0"}</>
                                </Link>
                                <Link to="/" className="ins-ic">
                                <SocialIcon url="https://instagram.com/" />
                                <>{"\u00a0\u00a0"}</>
                                </Link>
                                <Link to="/" className="gp-ic">
                                <SocialIcon url="https://googleplus.com/" />
                                <>{"\u00a0\u00a0"}</>
                                </Link>
                                <Link to="/" className="wp-ic">
                                <SocialIcon url="https://whatsapp.com/" />
                                <>{"\u00a0\u00a0"}</>
                                </Link>
                                </MDBCol>
                        </MDBRow>
                    </MDBContainer>
                </div>
                <MDBContainer className="mt-5 mb-4 text-center text-md-left">
                    <MDBRow className="mt-3">
                        <MDBCol md="4" lg="3" xl="3" className="mb-3 dark-grey-text">
                            <h6 className="text-uppercase font-weight-bold">
                                <strong>Kisan Mart</strong>
                            </h6>
                            <hr className="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style={{ width: "60px" }} />
                            <p>
                                The purpose of Kisan Mart is to provide connections between different roles in the agriculture industry. As the farmers are not getting a fair price for their goods because of contractors. This app removes the requirement of contractors for farmers. 
                            </p>
                        </MDBCol>
                        <MDBCol md="4" lg="3" xl="3" className="mb-3 dark-grey-text">
                            <h6 className="text-uppercase font-weight-bold">
                                <strong>Links</strong>
                            </h6>
                            <hr className="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style={{ width: "60px" }} />
                            
                            <p><Link to="/Login" className="dark-grey-text">Login</Link></p>
                            <p><Link to="/register" className="dark-grey-text">Register</Link></p>
                            <p><Link to="/cart" className="dark-grey-text">Cart</Link></p>
                            <p><Link to="/aboutus" className="dark-grey-text">About Us</Link></p>
                        </MDBCol>
                        <MDBCol md="4" lg="3" xl="3" className="mb-3 dark-grey-text">
                            <h6 className="text-uppercase font-weight-bold">
                                <strong>Contact</strong>
                            </h6>
                            <hr className="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style={{ width: "60px" }} />
                            <p><i className="fa fa-home mr-3" /> Pune, Maharasshtra</p>
                            <p><i className="fa fa-envelope mr-3" /> kisanmart.cdac@gmail.com</p>
                            <p><i className="fa fa-phone mr-3" /> + 91-9876543210</p>
                            <p><i className="fa fa-print mr-3" /> + 91-8600989898</p>
                        </MDBCol>
                        <MDBCol md="4" lg="3    " xl="3" className="mb-3 dark-grey-text">
                        <a href='https://play.google.com'>
                            <img src={logo} alt="" height={"180"} width={250} />
                          </a>
                        </MDBCol>
                    </MDBRow>
                </MDBContainer>
                <div className="footer-copyright text-center py-3 " style={{ color: "white" }}>
                   
                    <MDBContainer fluid>
                        &copy; {new Date().getFullYear()} Copyright:{" "}
                    Kisan Mart
                </MDBContainer>
                
                </div>
            </MDBFooter>
        
    )
}

export default Footer
