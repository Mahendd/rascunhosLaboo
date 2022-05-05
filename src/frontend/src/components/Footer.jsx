import styles from "../styles/Index.module.css"
export default function Footer(props) {
    return (
        <footer className={styles.footer}>
            {props.children}
        </footer>
    )
}