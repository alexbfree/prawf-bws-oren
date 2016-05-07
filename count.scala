export NVM_DIR="/Users/bowyer/.nvm"
[ -s "$NVM_DIR/nvm.sh" ] && . "$NVM_DIR/nvm.sh"  # This loads nvm
export AMAZON_SECRET_ACCESS_KEY=02lqEuqkoJM69ARyhO36if2yaA2xRbT4P97ENJB9
export AWS_SECRET_ACCESS_KEY=02lqEuqkoJM69ARyhO36if2yaA2xRbT4P97ENJB9
export AMAZON_ACCESS_KEY_ID=AKIAIA3QM2SR5X5KLUMQ
export AWS_ACCESS_KEY_ID=AKIAIA3QM2SR5X5KLUMQ
export PATH=./node_modules/.bin:$PATH:~/bin
export DOCKER_HOST=tcp://192.168.59.103:2376
export DOCKER_CERT_PATH=/Users/bowyer/.boot2docker/certs/boot2docker-vm
export DOCKER_TLS_VERIFY=1

docker-ip() {
  boot2docker ip 2> /dev/null
}

HISTSIZE=2222
HISTFILESIZE=999999
HISTTIMEFORMAT="%Y%m%d-%T "
HISTIGNORE="&:pwd:ls:[bf]g:exit:[ \t]*"
shopt -s cmdhist
shopt -s histappend
export PROMPT_COMMAND="history -a; history -c; history -r; $PROMPT_COMMAND"
function hs {
grep $1 $HISTFILE
}

alias folderforget="defaults delete NSGlobalDomain NSNavRecentPlaces"
alias makesafe="git secrets --install && git secrets --register-aws"

source ~/.profile

# added by Anaconda 2.2.0 installer
export PATH="/Users/bowyer/anaconda/bin:$PATH"
export MICO_API_USERNAME=abowyer
export MICO_API_PASSWORD=T5KjcYFt7

[[ -s "$HOME/.rvm/scripts/rvm" ]] && source "$HOME/.rvm/scripts/rvm" # Load RVM into a shell session *as a function*

export PATH=~/npm/bin:/Users/bowyer/anaconda/bin:/Users/bowyer/.rvm/gems/ruby-2.1.2/bin:/Users/bowyer/.rvm/gems/ruby-2.1.2@global/bin:/Users/bowyer/.rvm/rubies/ruby-2.1.2/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/opt/X11/bin:/Local/bin:/Local/sbin:/Library/TeX/texbin:/Users/bowyer/.rvm/bin:/usr/local/mysql/bin:/Users/bowyer/.rvm/bin

eval "$(docker-machine env default)"

# Use `docker-cleanup --dry-run` to see what would be deleted.
function docker-cleanup {
  EXITED=$(docker ps -q -f status=exited)
  DANGLING=$(docker images -q -f "dangling=true")

  if [ "$1" == "--dry-run" ]; then
    echo "==> Would stop containers:"
    echo $EXITED
    echo "==> And images:"
    echo $DANGLING
  else
    if [ -n "$EXITED" ]; then
      docker rm $EXITED
    else
      echo "No containers to remove."
    fi
    if [ -n "$DANGLING" ]; then
      docker rmi $DANGLING
    else
      echo "No images to remove."
    fi
  fi
}
export CONSCRIPT_HOME=~/.conscript
export PATH=$PATH:~/bin:$CONSCRIPT_HOME/bin

