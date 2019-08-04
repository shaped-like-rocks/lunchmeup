import React from "react";
import styled from "styled-components";

const StyledLocation = styled.div`
    background-color: grey;
    min-height: 100px;
    max-height: 100vh;
    font-size: 24px;
    border-radius: 5px;
`;

const Location = ({location}) => (
    <StyledLocation>{location.name}</StyledLocation>
);

export default Location;