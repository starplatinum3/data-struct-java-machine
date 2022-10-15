split() {
   IFS=$'\n' read -d "" -ra arr <<< "${1//$2/$'\n'}"
   printf '%s\n' "${arr[@]}"
}
cat nowcoder.txt  | awk '{print $1}'

cat nowcoder.txt  | awk '{$1}'

split "apples,oranges,pears,grapes" ","

split "Apple	8	2
Banana	5	20
Orange	12	5
Durian	20	0" "\t"

res=split "apples,oranges,pears,grapes" ","

python print(1)

