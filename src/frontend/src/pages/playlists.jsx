import BodyGrid from "../components/BodyGrid"
import Header from "../components/Header"
import Main from "../components/Main"
import Footer from "../components/Footer"
import Playlist from "../components/Playlist"
export default function Playlists() {
    return (
        <BodyGrid>
          <Header>
            <h1>Minhas Playlists</h1>
          </Header>
          <Main>
            <Playlist />
          </Main>
        </BodyGrid>
    )
}