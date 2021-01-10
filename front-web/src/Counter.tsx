import { useEffect, useState } from "react";

// type Props = {
//     message: string;
// }

function Counter() {
// function Counter({ message }: Props) {
    // useEffect(() => {
    //     console.log("componente iniciou");
    // }, []);

    const [counter, setCounter] = useState(0);

    const handleIncrease = () => {
        setCounter(counter +1);

    }

    const handleDecrease = () => {
        setCounter(counter -1);
        
    }

    return (
        <div>
            <button onClick={handleIncrease}>Incrementar</button>
            <button onClick={handleDecrease}>Decrementar</button>
            <h1>Valor do contador: {counter}</h1>
        </div>
        
    )
}

export default Counter;