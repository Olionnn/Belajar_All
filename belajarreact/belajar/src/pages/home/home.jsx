import { ThemeContext } from '../../context/ThemeProvider';
import { getStyles } from '../../context/theming'
import Isinya from "../../component/isimenu/isinya";

import React, { useState, useContext } from "react";

export default function Home() {
  const { mode } = useContext(ThemeContext);
  const styles = getStyles(mode);
    return (
        <>
        {/* susah boy nanti ajah */}
        {/* <div className="d-none d-xl-block">
          <Chatbox/>
        </div> */}
        <div style={ styles.fullscreen }>
        <Isinya/>
        </div>

        </>

    );

}