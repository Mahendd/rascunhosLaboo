import Head from "next/head";
import BotaoCurvo from "../components/BotaoCurvo"
import style from "../styles/Index.module.css"
import Header from "../components/Header"
import Main from "../components/Main"
import Footer from "../components/Footer"

export default function Index() {
  return (
    <>
      <Head>
        <title>Musicaler</title>
      </Head>

      <div className={style.bodyContainer}>
        <Header>
          Musicaler
        </Header>
        <Main>
          <h2 className={style.subtitle}>Todas as suas músicas. Um só lugar.</h2>
          <Link>
            <BotaoCurvo name="Comece agora"/>
          </Link>
        </Main>
        <Footer>
          O melhor gerenciador musical
        </Footer>
      </div>
    </>
  );
}