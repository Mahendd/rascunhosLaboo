import BodyGrid from "../../components/BodyGrid"
import Header from "../../components/Header"
import Playlist from "../../components/Playlist"
import styles from "../../styles/Playlists.module.css"
import Stack from "@mui/material/Stack"
import Button from "@mui/material/Button"
import Navbar from "../../components/Navbar"
import Navbtn from '../../components/Navbtn';

export default function Playlists() {
    return (
      <>
        <Navbar>
          <Navbtn to="#">
            Busca
          </Navbtn>
          <Navbtn to="#" selected>
            Playlists
          </Navbtn>
        </Navbar>
        
        <BodyGrid>
          <Header>
            <h1>Minhas Playlists</h1>
          </Header>
          <main className={styles.main}>
            <Stack spacing={2}>
              <Playlist to="/playlists/samba" title="Samba Boêmio" qtmusicas="51" avatar={avatar(50)} />
              <Playlist to="/playlists/samba" title="Rock Pesadão" qtmusicas="666" avatar={avatar(180)}/>
              <Playlist to="/playlists/samba" title="Para chorar no banho" qtmusicas="26" avatar={avatar(6969)}/>
              <Playlist to="/playlists/samba" title="Baguncinha com os amigos" qtmusicas="42" avatar={avatar(4242)}/>

              <Button color="success" variant="contained">Adicionar Playlist</Button>
            </Stack>
          </main>
        </BodyGrid>
      </>
    )
}

function avatar(seed) {
  return "https://avatars.dicebear.com/api/identicon/" + seed+".svg"
}