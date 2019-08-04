import React from 'react';
import Enzyme, {shallow} from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import Location from "../../main/components/Location";

Enzyme.configure({adapter: new Adapter()});

it("Location includes location as text passed as prop", () => {
    const location = shallow(<Location location="aLocation" />);
    console.log(location.text());
    expect(location.text()).toEqual("aLocation");
});