import BotaoCurvo from "../components/BotaoCurvo"
import styles from "../styles/Index.module.css"
import Footer from "../components/Footer"
import Header from "../components/Header"
import Main from "../components/Main"
import BodyGrid from "../components/BodyGrid"

export default function Index() {
  return (
    <BodyGrid>
      <Header>
        <h1>Musicaler</h1>
      </Header>
      <Main>
        <h2>Todas as suas músicas. Um só lugar.</h2>
        <BotaoCurvo to="/playlists">Comece agora</BotaoCurvo>
      </Main>
      <Footer>
        <p>O melhor gerenciador musical</p>
      </Footer>
    </BodyGrid>
  )
} 