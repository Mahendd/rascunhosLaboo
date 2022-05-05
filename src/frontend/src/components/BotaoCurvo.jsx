import Link from "next/link"
import styles from "./BotaoCurvo.module.css"

export default function BotaoCurvo(props) {
    return (
        <Link href={props.to}>
            <button className={styles.button}>{props.children}</button>
        </Link>
    )
}