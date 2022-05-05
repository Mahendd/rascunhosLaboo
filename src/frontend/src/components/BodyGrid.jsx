import styles from "../styles/Index.module.css"

export default function BodyGrid(props) {
  return (
    <div className={styles.bodyContainer}>
      {props.children}
    </div>
  )
}