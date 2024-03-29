
function slist (target) {
  // (A) SET CSS + GET ALL LIST ITEMS
  target.classList.add("slist");
  let items = target.getElementsByTagName("li"), current = null;

  // (B) MAKE ITEMS DRAGGABLE + SORTABLE
  for (let i of items) {
    // (B1) ATTACH DRAGGABLE
    i.draggable = true;

    // (B2) DRAG START
    i.ondragstart = (ev) => {
      current = i;
      for (let it of items) {
        if (it != current) { it.querySelector("p").classList.add("hint"); }
      }
    };

    // (B3) DRAG ENTER
    i.ondragenter = (ev) => {
      if (i != current) { i.querySelector("p").classList.add("active"); }
    };

    // (B4) DRAG LEAVE
    i.ondragleave = () => {
      i.querySelector("p").classList.remove("active");
    };

    // (B5) DRAG END - REMOVE ALL HIGHLIGHTS
    i.ondragend = () => { for (let it of items) {
        it.querySelector("p").classList.remove("hint");
        it.querySelector("p").classList.remove("active");
    }};

    // (B6) DRAG OVER - PREVENT THE DEFAULT "DROP", SO WE CAN DO OUR OWN
    i.ondragover = (evt) => { evt.preventDefault(); };

    // (B7) ON DROP - DO SOMETHING
    i.ondrop = (evt) => {
      evt.preventDefault();
      if (i != current) {
        iValue = i.querySelector("input").value;
        currentValue = current.querySelector("input").value;

//        i.querySelector("input").value = currentValue;
//        current.querySelector("input").value = iValue;

        let currentpos = 0, droppedpos = 0;
        for (let it=0; it<items.length; it++) {
          if (current == items[it]) { currentpos = it; }
          if (i == items[it]) { droppedpos = it; }
        }
        if (currentpos < droppedpos) {
          i.parentNode.insertBefore(current, i.nextSibling);
        } else {
          i.parentNode.insertBefore(current, i);
        }

        let pos=1;
        for(const element of items){
            element.querySelector("input").value=pos;
            pos++;
        }
      }
    };
  }
}