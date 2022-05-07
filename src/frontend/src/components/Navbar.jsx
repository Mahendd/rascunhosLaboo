import { Component } from "react";
import { Avatar } from "@mui/material";
import styles from "./Navbar.module.css"
import Grid from '@mui/material/Grid';

export default class Navbar extends Component {
    constructor (props) {
        super(props)
    }

    render () {
        return (
            <Grid container className={styles.navbar}>
                <Grid item md={3} sm={5} xs={12} className={styles.logo}>
                        <Avatar variant="square" alt="Teste" src="assets/logo.svg" />
                        <h1>Musicaler</h1>
                </Grid>
                <Grid item md={7} sm={5} xs={8} className={styles.buttons}>
                        {this.props.children}
                </Grid>
                <Grid item md={2} sm={2} xs={4} className={styles.userSpace}>
                    <Avatar className={styles.user} variant="square" alt="Teste" src="assets/user.svg" />
                </Grid>
            </Grid>
        )
    }
}