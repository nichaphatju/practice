function solution(T) {
    console.log('----->> Input ' + T);
    let firstpart = '';
    let secondpart = '';
    let midpart = '';
    let mid = Math.floor(T.length/2);
    if(T.length % 2 === 0){
        firstpart = T.substring(0, T.length/2);
        secondpart = T.substring(T.length/2, T.length);
    }else{
        
        firstpart = T.substring(0, mid);
        secondpart = T.substring(mid+1, T.length);
        midpart = T.substring(mid,mid+1);
    }
    let rvSecondpart = reverse(secondpart);
    // console.log(' firstpart ', firstpart);
    // console.log(' secondpart ', secondpart);
    // console.log(' rv secondpart ', rvSecondpart);
    // console.log(' midpart ', midpart);

    let result = '';
    
    for(let i=0; i<firstpart.length;i++){
        let fChar = firstpart.charAt(i);
        let sChar = rvSecondpart.charAt(i);
        // console.log(fChar + sChar)
        if(fChar !== '?' && sChar !== '?' && fChar !== sChar){
            return 'NO';
        }else if(fChar === '?' && sChar !== '?'){
            result += sChar;
        }else if(fChar !== '?' && sChar === '?'){
            result += fChar;
        }else if(fChar === '?' && sChar === '?'){
            result += 'a';
        }else{
            result += fChar;
        }
    }
    result += midpart;
    if(result.length > 0){
        for(let i=result.length-2; i>=0;i--){
            result += result[i];
        }
    }
    // console.log(result);
    return result;
}

function reverse(str){
    let newStr = '';
    for(let i=str.length-1; i >= 0 ; i--){
        newStr += str[i];
    }
    return newStr;
}

console.log(solution('?ab??a'))
console.log(solution('bab??a'))
console.log(solution('?a?'))
console.log(solution('???aaaa'))
console.log(solution('k?yak'))