// package click.uploadSns.api.domain.services;

// import org.springframework.security.core.authority.AuthorityUtils;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import
// org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import click.uploadSns.api.domain.models.User;
// import click.uploadSns.api.domain.repositories.UserMapper;
// import lombok.RequiredArgsConstructor;

// @Service
// @Transactional
// @RequiredArgsConstructor
// public class LoginService implements UserDetailsService {//
// vueから送られたトークンを検証する。承認が取れたらログインサクセスの処理に飛ぶ、awsのライブラリを使う

// private final UserMapper _userMapper;

// @Override
// public UserDetails loadUserByUsername(String username /*
// usernameParameterのcode */)
// throws UsernameNotFoundException {
// var res = this._userMapper.findByUserName(username);// findByUsernameメソッドを作る
// if (res.isPresent()) {
// return (UserDetails) new User(username, res.get().getPassword(),
// AuthorityUtils.createAuthorityList("USER"));
// } // 返ってきた値はspring側で保持 プリンシパル
// throw new UsernameNotFoundException(username);
// }

// }
