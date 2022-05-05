import Avatar from "@mui/material/Avatar"
import styles from "./Playlist.module.css"
import Button from "@mui/material/Button"
// A playlist recebe uma URL de avatar
// um título
export default function Playlist(props) {
    return (
      <div className={[styles.playlist, styles.fade_in].join(" ")}>
        <div className={styles.avatarRegion}>
          <Avatar alt="Teste" className={styles.avatar} src={props.avatar} />
        </div>
        <div className={styles.body}>
          <h2>{props.title}</h2>
          <h3>{props.qtmusicas} músicas</h3>
          <Button variant="outlined" color="success">Ver músicas</Button>
        </div>
      </div>
    )
}