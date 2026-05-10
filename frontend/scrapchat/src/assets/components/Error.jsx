export default function Error({isError, errorString}){
    return(
        isError?<div className="error">
            <p className="error_string">{errorString}</p>
        </div>:null
    )
};