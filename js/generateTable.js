function solution(A, K) {
    // Implement your solution here
    
        let maxDigit = 1;
        for(let i=0; i<A.length; i++){
            let num = "" + A[i];
            if(num.length > maxDigit){
             maxDigit = num.length
            }
        }
        //console.log(maxDigit)

        let col = Math.min(K, A.length);
        let line = A.length < K ? 1 : Math.ceil(A.length/col);
        line = (line*2)+1;      // add border
        //console.log(line)

        let str = '';
         
        let countNum = 0;
         for(let l=0; l< line; l++){
            if(l%2 == 0){
                if(l == line-1){
                    col = A.length%K;
                }
                for(let i=0; i<col; i++){
                    str+='+';
                    for(let j=0; j< maxDigit ; j++){
                        str+='-';
                    }

                }
                str+='+';
            }else{
                for(let i=0; i<col; i++){
                    str+='|';
            
                    let n = "" + A[countNum];
                    let numLen = n.length;
                    for(let u=0; u<maxDigit -numLen; u++){
                        str+=' ';
                    }
                    str+=n;
                    countNum++;
                    if(countNum == A.length){
                        break;
                    }
                }
                str+='|';
            }

            str+='\n';

         }
         console.log(str);

}

solution([4, 35, 80, 123, 12345, 44, 8, 5], 10)
solution([4, 35, 80, 123, 12345, 44, 8, 5, 24, 3], 4)