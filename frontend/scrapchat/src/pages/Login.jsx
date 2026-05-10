import {useEffect, useState} from "react";
import Error from "../assets/components/Error.jsx";

export default function Login() {

    const [heading, setHeading] = useState("Login")
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [cPassword, setCPassword] = useState("");
    const [error, toggleError] = useState(false);
    const [errorString, setErrorString] = useState("");

    useEffect(() => {
        if(password !== cPassword){
            toggleError(true)
            setErrorString("password does not match")
        }else{
            toggleError(false)
            setErrorString("");
        }
    }, [cPassword])

    function submitForm() {
    //     todo
    }

    /*below function is for the testing purpose only*/
    function toggle() {
        heading === "Login" ? setHeading("Signup") : setHeading("Login");
    }

    return (
        <div>
            <div className="login_container">
                {/*below onclick function is for testing purpose only*/}
                <h1 onClick={toggle}>{heading}</h1>
                <div className="row_container">
                    <div className="key">User Name</div>
                    <input className="value" type={"text"} onChange={(e) => setUsername(e.target.value)}
                           name={"username"}/>
                </div>
                <div className="row_container">
                    <div className="key">Password</div>
                    <input className="value" type={"password"} onChange={(e) => setPassword(e.target.value)}
                           name={"password"}/>
                </div>

                {
                    heading === "Signup" && (<div className="row_container">
                        <div className="key">Confirm Password</div>
                        <input className="value" type={"password"} onChange={(e) => setCPassword(e.target.value)}
                               name={"cpassword"}/>
                    </div>)
                }


                <input className="submitBtn" value={heading === "Login" ? "Login" : "Signup"} type={"submit"}
                       onClick={submitForm()}/>

                <Error isError={error} errorString={errorString}/>
            </div>
        </div>
    );
};