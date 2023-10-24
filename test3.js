function solution(S, T) {

    let M = T.length;
    let N = S.length;
    let lenDiff = M - N;
    if(lenDiff > 1){
        return 'IMPOSSIBLE';
    }

    if(T === S){
        return 'EQUAL';
    }else if(T.charAt(0) + S === T){
        return 'INSERT '+T.charAt(0);
    }else if(S.slice(0, -1) === T){
        return 'REMOVE '+S.charAt(N-1);
    }else if(lenDiff === 0){
        let ketUnmatch = [];
        let unmatchChar = {};
        for(let i=0; i <M; i++){
            if(S.charAt(i) !== T.charAt(i)){
                ketUnmatch.push(S.charAt(i));
                unmatchChar[S.charAt(i)] = T.charAt(i);
                unmatchChar[T.charAt(i)] = S.charAt(i);
            }
        }
        console.log(unmatchChar)
        if(ketUnmatch.length === 2){
            let tmpCh;
            for(let i=0; i<ketUnmatch.length; i++){
                console.log(unmatchChar[ketUnmatch[i]])
                if(i === 0){
                    tmpCh = unmatchChar[ketUnmatch[i]];
                }else if(tmpCh === ketUnmatch[i]){
                    return 'SWAP '+ tmpCh + ' ' + unmatchChar[ketUnmatch[i]];
                }
                
            }

        }
    }

    return 'IMPOSSIBLE';
}

console.log(solution('from', 'form'))
console.log(solution('gain', 'again'))
console.log(solution('parks', 'park'))
console.log(solution('o', 'odd'))
console.log(solution('fift', 'fifth'))