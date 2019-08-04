import React, {Component} from "react";
import Location from "../components/Location";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            locations: []
        }
    }

    componentWillMount() {
        fetch("/locations")
            .then(response => response.json())
            .then((data) => {
                this.setState({locations: data})
            });
    }

    render() {
        const locations = this.state.locations;
        return (
            <div>
                {locations.map(location =>
                    <Location location={location} />)}
            </div>

        );
    }
}

export default App;