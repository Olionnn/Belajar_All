import { Themes } from './Themes';
export const getStyles = (mode) => ({

    // universal item
    highlights: {
        color: Themes[mode].highlight
    },
    text: {
        textColor: Themes[mode].textColor,
        color: Themes[mode].textColor,
        fill: Themes[mode].textColor
    },
    theme: {
        borderBottom: '5px solid'.textColor,
        textColor: Themes[mode].textColor,
        backgroundColor: Themes[mode].backgroundColor,
        boxShadow: '0px 1px 8px 2px'+Themes[mode].textColor,
        color: Themes[mode].highlight,
    },

    border: {
        borderColor: Themes[mode].textColor
    },

    cbox: {
        backgroundColor: Themes[mode].backgroundColor
    },

    form: {
        color: Themes[mode].textColor,
        textColor: Themes[mode].textColor,
        borderColor: Themes[mode].highlight,
        backgroundColor: Themes[mode].backgroundColor,
    },
    fullscreen: {
        minHeight: '100vh',
       },

    // navbar item
    navbar:{
        backgroundColor: Themes[mode].color,
        borderColor: Themes[mode].highlight,
        boxShadow: '0px 1px 8px 2px'+Themes[mode].textColor
    },
    iconbg:{
        backgroundColor: Themes[mode].color,
        border: '2px solid',
        borderRadius: '50px',
        borderColor: Themes[mode].textColor,
    },

    button: {
        borderStyle: 'solid',
        borderColor: Themes[mode].textColor,
        textColor: Themes[mode].textColor,
        backgroundColor: Themes[mode].backgroundColor,
        color:Themes[mode].textColor,
    },

    inofcanvabutton: {
        border: 'none',
        textAlign:'left',
        borderRadius: '0px',
        borderBottom: ' 1px solid',
        borderColor: Themes[mode].textColor,
        textColor: Themes[mode].textColor,
        backgroundColor: Themes[mode].backgroundColor,
        color:Themes[mode].textColor,
    },

    ofcanvasbutton: {
        backgroundColor: Themes[mode].textColor,
        borderColor: Themes[mode].highlight,
        fill: Themes[mode].textColor
    },

    //Isinya(content item)
    box: {
        border: '1px solid',
        backgroundColor: Themes[mode].color,
        boxShadow: '0px 4px 8px 0px'+Themes[mode].textColor,
    },

    postcard: {
        border: '1px solid',
        borderColor: Themes[mode].textColor,
        backgroundColor: Themes[mode].backgroundColor,
        textColor: Themes[mode].textColor,
        color: Themes[mode].textColor,
    }

  });
  