import BodyGrid from "../components/BodyGrid"
import Header from "../components/Header"
import Main from "../components/Main"
import Footer from "../components/Footer"
import Playlist from "../components/Playlist"
import styles from "../styles/Playlists.module.css"
export default function Playlists() {
    return (
        <BodyGrid>
          <Header>
            <h1>Minhas Playlists</h1>
          </Header>
          <main className={styles.main}>
            <Playlist title="Samba Boêmio" avatar={avatar(50)} />
            <Playlist title="Rock Pesadão" avatar={avatar(180)}/>
            <Playlist title="Para chorar no banho" avatar={avatar(6969)}/>
            <Playlist title="Baguncinha com os amigos" avatar={avatar(4242)}/>
            
          </main>
        </BodyGrid>
    )
}

function avatar(seed) {
  return "https://avatars.dicebear.com/api/identicon/" + seed+".svg"
}