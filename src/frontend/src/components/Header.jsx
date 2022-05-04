import style from "../styles/Index.module.css"

export default function Header (props) {
    return (
        <header className={style.header}>
          <h1 className={style.title}>{props.children}</h1>
        </header>
    )
}