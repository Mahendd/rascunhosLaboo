import style from "../styles/Index.module.css"

export default function Footer(props) {
    return (
        <footer className={style.footer}>
            {props.children}
        </footer>
    )
}