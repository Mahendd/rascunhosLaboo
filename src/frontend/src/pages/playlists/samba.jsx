import Navbar from "../../components/Navbar";
import Navbtn from "../../components/Navbtn";

export default function Samba() {
    return (
        <Navbar>
            <Navbtn to="#">
                Busca
            </Navbtn>
            <Navbtn to="/playlists">
                Playlists
            </Navbtn>
        </Navbar>
    )
}