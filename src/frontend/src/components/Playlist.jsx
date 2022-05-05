import Avatar from "@mui/material/Avatar"
import styles from "./Playlist.module.css"

// A playlist recebe uma URL de avatar
// um título
export default function Playlist(props) {
    return (
      <div className={[styles.playlist, styles.fade_in].join(" ")}>
        <div className={styles.avatarRegion}>
          <Avatar alt="Teste" className={styles.avatar} src={props.avatar} />
        </div>
        <div className={styles.body}>
          <h1>{props.title}</h1>
        </div>
      </div>
    )
}