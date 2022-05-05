import styles from "../styles/Index.module.css"
export default function Header(props) {
    return (
        <header className={styles.header}>
            {props.children}
        </header>
    )
}