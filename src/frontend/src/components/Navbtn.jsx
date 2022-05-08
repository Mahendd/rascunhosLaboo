import Link from "next/link";
import styles from "./Navbtn.module.css"
export default function Navbtn(props) {
    var classname;
    if (props.selected) {
        classname= styles.selected;
    }
    return (
        <Link href={props.to}>
            <p className={[classname, styles.botao].join(" ")}>{props.children}</p>
        </Link>
    )
}