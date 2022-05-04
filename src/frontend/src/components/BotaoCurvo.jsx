import { Component } from "react";
import style from "../styles/BotaoCurvo.module.css"

export default class Botao extends Component {
    render() {
        return (
            <button className={style.BotaoCurvo}>{this.props.name}</button>
        )
    }
}